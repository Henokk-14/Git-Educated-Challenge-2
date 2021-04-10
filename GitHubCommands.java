import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;
import git.tools.client.*;

public class GitHubCommands {
  GitSubprocessClient gitSubprocessClient;
  public GitHubCommands(){
    String repoPath = "/Users/henokk_14/Downloads/CSC 109/Git-Educated-Challenge-2";
    GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
    String status = gitSubprocessClient.gitStatus();
    GitAdd( gitSubprocessClient,"GitHubCommands.java");
    String commitMessage = "added-Commit,Push-to-functions";
    Commit(gitSubprocessClient, commitMessage);
    Push(gitSubprocessClient, "main");
  }
  public static void main(String[] args){
     GitHubCommands run =  new GitHubCommands();
  }

  public void GitAdd(GitSubprocessClient gitSubprocessClient,String filename) {
    try {
      String status = gitSubprocessClient.gitStatus();
      String gitAddFile = gitSubprocessClient.gitAddFile(filename);
      System.out.println(status);
    } catch (Exception e) {
      System.out.println("Error file name entered incorrect file:"+ filename+ " Doesn't exist in scope" );
    }
  }
  public void Commit(GitSubprocessClient gitSubprocessClient, String CommitMsg){
    try{
      String commit = gitSubprocessClient.gitCommit(CommitMsg);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void Push(GitSubprocessClient gitSubprocessClient, String BranchName){
    try{
      String push = gitSubprocessClient.gitPush(BranchName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
